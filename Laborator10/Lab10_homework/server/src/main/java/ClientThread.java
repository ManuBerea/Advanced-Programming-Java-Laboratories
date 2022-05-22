import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class ClientThread extends Thread{

    private Socket socket = null ;
    private BufferedReader in;
    private PrintWriter out;
    boolean loggedUser = false;
    String name = null;
    private final List<String> listOfFriends = new ArrayList<>();

    //file for storing clients
    File file= new File("C:\\Users\\manub\\IdeaProjects\\Lab10_homework\\server\\src\\main\\resources\\clients.txt");

    public ClientThread (Socket socket) {
        this.socket = socket ;
    }

    public void run () {
        try {
            // Get the request from the input stream: client → server
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Send the response to the oputput stream: server → client
            out = new PrintWriter(socket.getOutputStream());

            do {
                //send the response to the request
                responseRequest();

            } while (!socket.isClosed());

        } catch (IOException exception) {
            System.err.println("Communication error... " + exception);
        }
    }


    private void responseRequest()  {
        try {
            String request = in.readLine();
            if (request == null) {
                return;
            }
            PrintWriter output = new PrintWriter(socket.getOutputStream());
            String[] requestContent = request.split(" ");

            switch (requestContent[0]) {
                case "stop" -> {
                    out.println("Server stopped ! You can either exit or restart the app from the green triangle!");
                    out.close();
                    out.flush();
                    System.out.println("Connection terminated!");
                    System.exit(0);
                }

                case "register" -> {
                    out.flush();
                    name = requestContent[1];
                    if (inFile(name)) {
                        out.println("The client already exist!");
                        out.flush();
                    } else {
                        FileWriter fileWritter = new FileWriter(file, true);
                        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                        bufferWritter.append(name);
                        bufferWritter.newLine();
                        bufferWritter.close();
                        out.println("registration-successful");
                    }
                }

                case "login" -> {
                    name = requestContent[1];
                    if (inFile(name)) {
                        out.println("login-successful");
                        loggedUser = true;
                        out.flush();
                    }
                    // check if the name exists and return the response
                }

                case "logout" -> {
                    name = null;
                    loggedUser = false;
                    listOfFriends.clear();
                    out.println("logout-successful");
                    out.flush();
                }

                case "friend" -> {
                    // check to see if the client is logged in, then execute
                    if(loggedUser) {
                        for (int i = 1; i < requestContent.length; i++) {
                            if(inFile(requestContent[i]) && !requestContent[i].equals(name) && !listOfFriends.contains(requestContent[i])) {
                                listOfFriends.add(requestContent[i]);
                            }
                            out.println("Your friends:" + listOfFriends);
                        }
                    }
                    else {
                        out.println("You must login first!");
                    }
                }

                case "unfriend" -> {
                    if(loggedUser) {
                        for (int i = 1; i < requestContent.length; i++) {
                            if(inFile(requestContent[i]) && !requestContent[i].equals(name)) {
                                listOfFriends.remove(requestContent[i]);
                            }
                            out.println("Your friends:" + listOfFriends);
                        }
                    }
                    else {
                        out.println("You must login first!");
                    }
                }

                case "send" -> {
                    if(loggedUser) {
                        StringBuilder message = new StringBuilder();
                        for (int i = 1; i < requestContent.length; i++) {
                            message.append(requestContent[i]).append(" ");
                        }

                        if(listOfFriends.size() > 0) {
                            out.println("Message: " + message + " has been sent to your friends!");
                            out.flush();
//                          message.append("\n");
                            try {
                                for (int j = 0; j < listOfFriends.size(); j++) {
                                    File myFile = new File("C:\\Users\\manub\\IdeaProjects\\Lab10_homework\\server\\src\\main\\resources\\" + name + "-" + listOfFriends.get(j) + ".txt");
                                    if (myFile.createNewFile()) {
                                        FileWriter fileWritter = new FileWriter(myFile, true);
                                        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                                        bufferWritter.append(message);
                                        bufferWritter.append("\n");
                                        bufferWritter.close();

//                                        FileOutputStream fos = new FileOutputStream(myFile);
//                                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
//                                        bw.write(String.valueOf(message));
//                                        bw.newLine();
//                                        bw.close();
                                    } else {
                                        FileWriter fileWritter = new FileWriter(myFile, true);
                                        BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
                                        bufferWritter.append(message);
                                        bufferWritter.append("\n");
                                        bufferWritter.close();
                                    }
                                }
                            } catch (IOException e) {
                                System.out.println("An error occurred.");
                                e.printStackTrace();
                            }
                        }
                        else {
                            out.println("You have no friends to send message! :(");
                            out.flush();
                        }
                    }
                    else {
                        out.println("You must login first!");
                        out.flush();
                    }
                }

                case "read" -> {
                    if(loggedUser) {
                        int nrOfNewMessages = 0;
                        for (int j = 0; j < listOfFriends.size(); j++) {
                            String path = "C:\\Users\\manub\\IdeaProjects\\Lab10_homework\\server\\src\\main\\resources\\" + listOfFriends.get(j) + "-" + name + ".txt";
                            if(Files.exists(Path.of(path))) {
                                nrOfNewMessages++;
                                try {
                                    File myObj = new File(path);
                                    Scanner myReader = new Scanner(myObj);
                                    while (myReader.hasNextLine()) {
                                        String data = myReader.nextLine();
                                        out.println(data);
                                    }
                                    myReader.close();

                                } catch (Exception e) {
                                    System.err.println("Error: " + e.getMessage());
                                }

//                                try {
//                                    File file=new File(path);    //creates a new file instance
//                                    FileReader fr=new FileReader(file);   //reads the file
//                                    BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
//                                    StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters
//                                    String line;
//                                    while((line=br.readLine())!=null) {
//                                        sb.append(line);      //appends line to string buffer
//                                        sb.append("\n");     //line feed
//                                    }
//                                    fr.close();    //closes the stream and release the resources
////                                    System.out.println(sb);
//                                    out.print(sb);
//                                }
//                                catch(IOException e) {
//                                    e.printStackTrace();
//                                }


                                File deleteFile = new File(path);
                                new FileWriter(path, false).close();
                                if(deleteFile.delete()){
                                    System.out.println(deleteFile.getName() + " deleted");
                                }
                                else {
                                    System.out.println("Failed to delete the file");
                                }
                            }
                        }
                        if(nrOfNewMessages == 0) {
                            out.println("You have no messages received!");
                            out.flush();
                        }
                    }
                    else {
                        out.println("You must login first!");
                        out.flush();
                    }
                }

                default -> out.println("Server received the BAD request: " + request);
            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean inFile(String parametru) {
        Scanner scanner;
        try {
            scanner = new Scanner(file).useDelimiter( "\n");

            while (scanner.hasNext()) {
                final String lineFromFile = scanner.nextLine();
                if (lineFromFile.contains(parametru)) {
                    return true;
                }
            }

        } catch (IOException e) {
            System.out.println(" cannot write to file " + file.toString());
        }
        return false;
    }

}

