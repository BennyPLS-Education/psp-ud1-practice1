import java.util.regex.Pattern;

public class URL {

    private static final Pattern URL_PATTERN = Pattern.compile("^(http|https)://.*$");

    // Properties
    private String url;

    // Constructors

    public URL(String url) throws IllegalArgumentException {
        this.url = url;

        if (!validateUrl()) {
            throw new IllegalArgumentException("Invalid URL");
        }
    }

    // Public Methods


    // Private Methods

    private boolean validateUrl() {
        return URL_PATTERN.matcher(this.url).matches();
    }

    // Setters & Getters

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
