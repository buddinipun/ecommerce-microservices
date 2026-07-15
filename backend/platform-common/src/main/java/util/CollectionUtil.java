package util;
import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.List;


@UtilityClass
public class CollectionUtil {


    public boolean isEmpty(
            Collection<?> collection
    ) {

        return collection == null 
                || collection.isEmpty();

    }



    public boolean isNotEmpty(
            Collection<?> collection
    ) {

        return !isEmpty(collection);

    }



    public <T> List<T> emptyIfNull(
            List<T> list
    ) {

        return list == null
                ? List.of()
                : list;

    }



    public int size(
            Collection<?> collection
    ) {

        return collection == null
                ? 0
                : collection.size();

    }

}