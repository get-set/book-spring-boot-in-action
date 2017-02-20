## 4.3 文件上传配置

1. 添加文件上传所需的依赖，包括`commons-fileupload`和`commons-io`。
2. 在上传页面上增加form表单，enctype为`multipart/form-data`。
3. 在配置文件中，通过配置一个`MultipartResolver`来上传文件。
4. 在控制器中，通过`MultipartFile`来接收文件，通过`MultipartFile[]`接收多个文件的上传。