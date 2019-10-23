<?php

use Symfony\Component\OptionsResolver\Exception\UndefinedOptionsException;

require_once(__DIR__ . '/vendor/autoload.php');

include("lib/Api/EmployeesApiControllerApi.php");
include("lib/Model/Employee.php");

$apiInstance = new Swagger\Client\Api\EmployeesApiControllerApi(new GuzzleHttp\Client());

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $action = $_POST['action'];
    if ($action == "add"){
       // adiciona
        if (empty($_POST["Name"])) {
            $nameErr = "Name is required";
        } else {
            $name =$_POST["Name"];
        }
        if (empty($_POST["Title"])) {
            $titleErr = "Title is required";
        } else {
            $title = $_POST["Title"];
        }
        if (empty($_POST["Id"])) {
            $idErr = "ID is required";
        } else {
            $id = $_POST["Id"];
        }
 
        $body = new \Swagger\Client\Model\Employee();
        $body->setEmployeeName($name);
        $body->setEmployeeTitle($title);
        $body->setId($id);
        try {
 
           $apiInstance->employeesPost($body);
           $emp = $apiInstance->employeesIdGet($id);
           
        } catch (Exception $e) {
           echo 'Exception when calling EmployeesApiControllerApi->employeesPost: ', $e->getMessage(), PHP_EOL;
        }
    }
    if ($action == "delete"){
        // remove
         $id = $_POST["IdRemove"];
         try {
             $result = $apiInstance->employeesIdDelete($id);
             print_r($result);
         } catch (Exception $e) {
             echo 'Exception when calling EmployeesApiControllerApi->employeesIdDelete: ', $e->getMessage(), PHP_EOL;
         }
    }
    if ($action == "update"){
         
            $id = $_POST["IdUpdate"];
        
            $Newname =$_POST["NewName"];
        
            $Newtitle = $_POST["NewTitle"];
       
            $Newid = $_POST["NewId"];
       
         try {
            $result = $apiInstance->employeesIdDelete($id);


            $body = new \Swagger\Client\Model\Employee();
            $body->setEmployeeName($Newname);
            $body->setEmployeeTitle($Newtitle);
            $body->setId($Newid);
            $apiInstance->employeesPost($body); 
            
         } catch (Exception $e) {
             echo 'Exception when calling EmployeesApiControllerApi->employeesIdDelete: ', $e->getMessage(), PHP_EOL;
         }
    }
}




?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="mystyle.css">
    <title>Document</title>
</head>
<body>
    <div class="container">
        <div class="division">
            POST<br>
            <form action="index.php" method="Post">
                <div class"label">Name:</div> <input type="text" name="Name" required><br>
                <div class"label">Title:</div> <input type="text"  name="Title" required><br>
                <div class"label">ID:</div> <input type="text"  name="Id" required><br>
                <input type="hidden" name="action" value="add">
                <input type="submit" value="Post">
            </form>
        </diV>
        <div class="division">
            GET<br>
           <?php
           $apiInstance = new Swagger\Client\Api\EmployeesApiControllerApi(
                new GuzzleHttp\Client()
            );
            
            $body_limit = 56; // int | The amount of employees returned
            $page_limit = 5; // int | The pages to  return employees info

            $result = $apiInstance->employeesGet($body_limit, $page_limit);
            //NOTE
            foreach ($result as list("id" => $idLis, "employee_name" => $nameLis, "employee_title" => $titleLis )) {
                    echo "<ul>\n" .
                        "<li>$idLis</li>\n" .
                        "<li>$nameLis</li>\n" .
                        "<li>$titleLis</li>\n" .
                        "</ul>\n";
                }

            ?>
        </diV>
        <div class="division">
            
            GETBYID<br>
            <form action="index.php">
                <div class"label">ID:</div> <input type="text" name="IdGet" required><br>
                <input type="submit" value="Get by ID">
                <input type="hidden" name="action" value="getId">
            </form>
            <div class="display" id="displayGETBYID">
                <?php
               
                if(empty($_GET["IdGet"])){
                    ?><b>Name:</b> <?php print_r("");?><br><?php
                    ?><b>Title:</b> <?php print_r("");?><br><?php
                    ?><b>Id:</b> <?php print_r("");?><br><?php
                }else{
                    $id = $_GET["IdGet"];
                    try {
                        $result = $apiInstance->employeesIdGet($id);
                        ?><b>Name:</b> <?php print_r($result->getEmployeeName());?><br><?php
                        ?><b>Title:</b> <?php print_r($result->getEmployeeTitle());?><br><?php
                        ?><b>Id:</b> <?php print_r($id);?><br><?php
                        
                        
                    } catch (Exception $e) {
                        echo 'Exception when calling EmployeesApiControllerApi->employeesIdDelete: ', $e->getMessage(), PHP_EOL;
                    }
                }
                   
                ?>
            </div>
        </diV>
        <div class="division">
        DELETE
            <form action="index.php" method="Post">
                <div class"label">ID:</div> <input type="text" name="IdRemove" required><br>
                <input type="hidden" name="action" value="delete">
                <input type="submit" value="Delete">
            </form>
            
        </diV>
        <div class="division">
        UPDATE
            <form action="index.php" method="Post">
                <div class"label"><b>ID:</b></div> <input type="text" name="IdUpdate" required><br>
                <div class"label">Name:</div> <input type="text" name="NewName" required><br>
                <div class"label">Title:</div> <input type="text"  name="NewTitle" required><br>
                <div class"label">NewID:</div> <input type="text"  name="NewId" required><br>
                <input type="hidden" name="action" value="update">
                <input type="submit" value="Update">
            </form>
            
        </diV>
    </div>
</body>
</html>