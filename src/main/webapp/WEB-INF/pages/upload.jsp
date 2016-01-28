<%@ page session="false" %>
<html>
<head>
    <title>Upload File Page</title>
</head>
<body>

<form method="POST" action="upload" enctype="multipart/form-data">
    File to upload:<br/><input type="file" name="file"><br/>
    <input type="submit" value="Upload">
</form>

</body>
</html>