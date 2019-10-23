# Swagger\Client\EmployeesApiControllerApi

All URIs are relative to *https://localhost:8080*

Method | HTTP request | Description
------------- | ------------- | -------------
[**employeesGet**](EmployeesApiControllerApi.md#employeesGet) | **GET** /employees | employeesGet
[**employeesIdDelete**](EmployeesApiControllerApi.md#employeesIdDelete) | **DELETE** /employees/{id} | employeesIdDelete
[**employeesIdGet**](EmployeesApiControllerApi.md#employeesIdGet) | **GET** /employees/{id} | employeesIdGet
[**employeesPost**](EmployeesApiControllerApi.md#employeesPost) | **POST** /employees | employeesPost


# **employeesGet**
> \Swagger\Client\Model\Employee[] employeesGet($body_limit, $page_limit)

employeesGet

Obtain information about emloyees from the HR database

### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');

$apiInstance = new Swagger\Client\Api\EmployeesApiControllerApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client()
);
$body_limit = 56; // int | The amount of employees returned
$page_limit = 56; // int | The pages to  return employees info

try {
    $result = $apiInstance->employeesGet($body_limit, $page_limit);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling EmployeesApiControllerApi->employeesGet: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body_limit** | **int**| The amount of employees returned | [optional]
 **page_limit** | **int**| The pages to  return employees info | [optional]

### Return type

[**\Swagger\Client\Model\Employee[]**](../Model/Employee.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **employeesIdDelete**
> \Swagger\Client\Model\Employee employeesIdDelete($id)

employeesIdDelete

Obtain information about specific employee

### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');

$apiInstance = new Swagger\Client\Api\EmployeesApiControllerApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client()
);
$id = 56; // int | id

try {
    $result = $apiInstance->employeesIdDelete($id);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling EmployeesApiControllerApi->employeesIdDelete: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| id |

### Return type

[**\Swagger\Client\Model\Employee**](../Model/Employee.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/xml, application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **employeesIdGet**
> \Swagger\Client\Model\Employee employeesIdGet($id)

employeesIdGet

Obtain information about specific employee

### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');

$apiInstance = new Swagger\Client\Api\EmployeesApiControllerApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client()
);
$id = 56; // int | id

try {
    $result = $apiInstance->employeesIdGet($id);
    print_r($result);
} catch (Exception $e) {
    echo 'Exception when calling EmployeesApiControllerApi->employeesIdGet: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **int**| id |

### Return type

[**\Swagger\Client\Model\Employee**](../Model/Employee.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/xml, application/json

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

# **employeesPost**
> employeesPost($body)

employeesPost

Creates a new employee in the database

### Example
```php
<?php
require_once(__DIR__ . '/vendor/autoload.php');

$apiInstance = new Swagger\Client\Api\EmployeesApiControllerApi(
    // If you want use custom http client, pass your client which implements `GuzzleHttp\ClientInterface`.
    // This is optional, `GuzzleHttp\Client` will be used as default.
    new GuzzleHttp\Client()
);
$body = new \Swagger\Client\Model\Employee(); // \Swagger\Client\Model\Employee | body

try {
    $apiInstance->employeesPost($body);
} catch (Exception $e) {
    echo 'Exception when calling EmployeesApiControllerApi->employeesPost: ', $e->getMessage(), PHP_EOL;
}
?>
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**\Swagger\Client\Model\Employee**](../Model/Employee.md)| body |

### Return type

void (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/xml, application/json
 - **Accept**: */*

[[Back to top]](#) [[Back to API list]](../../README.md#documentation-for-api-endpoints) [[Back to Model list]](../../README.md#documentation-for-models) [[Back to README]](../../README.md)

