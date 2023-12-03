<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "kalyani";
$port = "3306";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname, $port);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// Fetch data from the database table
$sql = "SELECT * FROM jdbc_details";
$result = $conn->query($sql);

// Display table rows with fetched data
if ($result->num_rows > 0) {
    while ($row = $result->fetch_assoc()) {
        echo "<tr>";
        echo "<td>" . $row['first_name'] . "</td>";
        echo "<td>" . $row['last_name'] . "</td>";
        echo "<td>" . $row['age'] . "</td>";
        echo "</tr>";
    }
} else {
    echo "<tr><td colspan='3'>No data found</td></tr>";
}

// Close connection
$conn->close();
?>