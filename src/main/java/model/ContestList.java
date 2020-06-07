package model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContestList {

    @SerializedName("meta")
    @Expose
    private Meta meta;
    @SerializedName("objects")
    @Expose
    private List<Object> objects = null;
}