package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Object {

    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("end")
    @Expose
    private String end;
    @SerializedName("event")
    @Expose
    private String event;
    @SerializedName("href")
    @Expose
    private String href;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("resource")
    @Expose
    private Resource resource;
    @SerializedName("start")
    @Expose
    private String start;

}