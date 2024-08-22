package cloud.exception;

import cloud.constant.ReturnCode;
import cloud.entities.ResultDate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @since 2024/8/22
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandle {
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultDate<String> handleRuntimeException(RuntimeException exception) {
        System.out.println("################### start global exception handle ###################");
        log.error("全局异常信息：{}", exception.getMessage(), exception);
        return ResultDate.fail(ReturnCode.RC500.getCode(), exception.getMessage());
    }
}
