package personal.system.com.dhwanitaskabhinav.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example1 extends BaseApiResponseModel {

    @SerializedName("state")
    @Expose
    private List<State> state = null;


    public List<State> getState() {
        return state;
    }

    public void setState(List<State> state) {
        this.state = state;
    }

    public class State {

        @SerializedName("id")
        @Expose
        private int id;
        @SerializedName("state_name")
        @Expose
        private String stateName;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStateName() {
            return stateName;
        }

        public void setStateName(String stateName) {
            this.stateName = stateName;
        }


    }
}
