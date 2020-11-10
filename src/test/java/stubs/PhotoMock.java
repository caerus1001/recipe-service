package stubs;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.spire.recipeservice.Photo;

public class PhotoMock {
    public static Photo getPhoto() {
        return new Photo("42", "title", new Binary(BsonBinarySubType.BINARY, new byte[0]));
    }
}
