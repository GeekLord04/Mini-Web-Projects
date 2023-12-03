<?php
// Establish connection to MySQL database
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "authentication";
$port = "3306";

$conn = new mysqli($servername, $username, $password, $dbname, $port);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Retrieve user input from the form
$username = $_POST['username'];
$password = $_POST['password'];

// SQL query to check if username and password match
$sql = "SELECT * FROM users WHERE username = '$username' AND password = '$password'";
$result = $conn->query($sql);

// Check if result has rows (i.e., if a matching user was found)
if ($result->num_rows > 0) {
    echo "Login successful!";
    // Redirect to a new page or perform additional actions after successful login
} else {
    echo "Invalid username or password";
}

$conn->close();
?>
