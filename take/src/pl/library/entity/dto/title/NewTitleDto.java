package pl.library.entity.dto.title;

public class NewTitleDto {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NewTitleDto(String name) {
        this.name = name;
    }

    public NewTitleDto() {
    }

    
}
