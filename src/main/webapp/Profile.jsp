<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Welcome Page</title>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
<style>
body {
    font-family: 'Poppins', sans-serif;
    background: linear-gradient(135deg, #1e3c72, #2a5298);
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    margin: 0;
}
.welcome-container {
    text-align: center;
    background-color: rgba(255, 255, 255, 0.1);
    padding: 40px;
    border-radius: 10px;
    backdrop-filter: blur(10px);
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
}
h2 {
    font-size: 48px;
    color: #ffffff;
    margin-bottom: 20px;
}
.message {
    font-size: 20px;
    color: #ffffff;
}
</style>
</head>
<body>
<div class="welcome-container">
    <h2>Welcome, ${session_name}!</h2>
    <p class="message">We're glad to have you here.</p>
</div>
</body>
</html>
