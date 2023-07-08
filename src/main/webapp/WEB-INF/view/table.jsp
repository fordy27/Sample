<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
    <title>Table</title>
</head>

<body>
    <div class="container">
        <div class="alert alert-success d-flex justify-content-center align-items-center flex-column">
        <img src="resources/img/download (6).jpg"  style="width:300; height:300px">
        <h1>Users</h1>
        <table class="table table-primary">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>password</th>
                    <th>Confirm Password</th>
                    <th colspan="2" class="text-center">
                        Action
                    </th>
                </tr>
            </thead>

            <tbody>
                <tr>
                    <td>colmeessaj</td>
                    <td>12345</td>
                    <td>12345</td>
                    <td><button class="btn btn-primary">Update</button></td>
                    <td><button class="btn btn-warning">Delete</button></td>
                </tr>
                <tr>
                    <td>molde</td>
                    <td>amaw</td>
                    <td>amaw</td>
                    <td><button class="btn btn-primary">Update</button></td>
                    <td><button class="btn btn-warning">Delete</button></td>
                </tr>
                <tr>
                    <td>nyow</td>
                    <td>hubagggg</td>
                    <td>hubagggg</td>
                    <td><button class="btn btn-primary">Update</button></td>
                    <td><button class="btn btn-warning">Delete</button></td>
                </tr>


            </tbody>



        </table>

    </div>


</body>

</html>