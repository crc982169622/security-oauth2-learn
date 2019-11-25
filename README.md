# security-oauth2-learn
学习spring security oauth2的代码

spring security oauth2有四种授权类型：

    1.授权码模式（authorization code） 
    
    2.简化模式（implicit） 
    
    3.密码模式（resource owner password credentials） 
    
    4.客户端模式（client credentials）
    
本案例目前是授权码模式，其流程如下：

    首先访问：localhost:8080/oauth/authorize?client_id=client&response_type=code 获取授权码，
    然后访问：http://client:secret@localhost:8080/oauth/token (参数为：grant_type=authorization_code，code=授权码) 获取access_token，
    最后带着access_token访问资源服务器。


