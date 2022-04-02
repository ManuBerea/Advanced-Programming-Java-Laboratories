<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bibliography</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }
        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<h1>Catalog located at ${catalogLocation} has items:</h1>
<table>
    <tbody>
        <#list items as item>
            <tr>
                <td>Id of the item: ${item.id}</td>
                <td>Title of the item: ${item.title}</td>
                <td>Location of the item: <a href="${item.location}">${item.location}</a></td>
                <td>Type of the item: ${item.type}</td>
            </tr>
        </#list>
    </tbody>
</table>
</body>
</html>
