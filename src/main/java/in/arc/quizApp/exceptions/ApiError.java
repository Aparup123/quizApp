package in.arc.quizApp.exceptions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError extends RuntimeException{
    private int statusCode;
    public ApiError(int statusCode, String message){
        super(message);
        this.statusCode = statusCode;
    }
}
