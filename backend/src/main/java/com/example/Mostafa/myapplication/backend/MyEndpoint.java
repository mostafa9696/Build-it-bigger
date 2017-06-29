

package com.example.Mostafa.myapplication.backend;

import com.example.GenerateJokes;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.Mostafa.example.com",
                ownerName = "backend.myapplication.Mostafa.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {


    @ApiMethod(name = "sayHi")
    public MyBean sayHi(@Named("name") String name) {
        MyBean response = new MyBean();
        GenerateJokes generateJokes=new GenerateJokes();
        response.setData(generateJokes.GetJoke());
        return response;
    }

}
