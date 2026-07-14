package exception;


public class DuplicateResourceException 
        extends BaseException {


    public DuplicateResourceException(
            String message
    ) {

        super(
            ErrorCode.DUPLICATE_RESOURCE,
            message
        );

    }

}