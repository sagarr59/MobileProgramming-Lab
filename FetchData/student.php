<?php
// student.php

// Set the content type to JSON
header('Content-Type: application/json');

// Get the JSON data from the request
$data = json_decode(file_get_contents('php://input'), true);

// Check if the data is valid
if (isset($data['name']) && isset($data['email']) && isset($data['phone'])) {
    $name = $data['name'];
    $email = $data['email'];
    $phone = $data['phone'];

    // Here you would normally insert the data into your database
    // For demonstration, we'll just respond with success

    // Respond with success
    echo json_encode(['status' => 'success', 'message' => 'Student inserted successfully']);
} else {
    // Respond with an error if data is missing
    http_response_code(400); // Bad Request
    echo json_encode(['status' => 'error', 'message' => 'Invalid input']);
}
?>