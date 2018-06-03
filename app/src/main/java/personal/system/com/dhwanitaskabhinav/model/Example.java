package personal.system.com.dhwanitaskabhinav.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("auth")
    @Expose
    private Object auth;
    @SerializedName("events")
    @Expose
    private Object events;
    @SerializedName("variables")
    @Expose
    private Object variables;
    @SerializedName("order")
    @Expose
    private List<String> order = null;
    @SerializedName("folders_order")
    @Expose
    private List<Object> foldersOrder = null;
    @SerializedName("folders")
    @Expose
    private List<Object> folders = null;
    @SerializedName("requests")
    @Expose
    private List<Request> requests = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public Object getAuth() {
        return auth;
    }

    public void setAuth(Object auth) {
        this.auth = auth;
    }

    public Object getEvents() {
        return events;
    }

    public void setEvents(Object events) {
        this.events = events;
    }

    public Object getVariables() {
        return variables;
    }

    public void setVariables(Object variables) {
        this.variables = variables;
    }

    public List<String> getOrder() {
        return order;
    }

    public void setOrder(List<String> order) {
        this.order = order;
    }

    public List<Object> getFoldersOrder() {
        return foldersOrder;
    }

    public void setFoldersOrder(List<Object> foldersOrder) {
        this.foldersOrder = foldersOrder;
    }

    public List<Object> getFolders() {
        return folders;
    }

    public void setFolders(List<Object> folders) {
        this.folders = folders;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }

}


class HeaderDatum {

    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("enabled")
    @Expose
    private Boolean enabled;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

}
class Request {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("data")
    @Expose
    private List<Object> data = null;
    @SerializedName("dataMode")
    @Expose
    private String dataMode;
    @SerializedName("headerData")
    @Expose
    private List<HeaderDatum> headerData = null;
    @SerializedName("method")
    @Expose
    private String method;
    @SerializedName("pathVariableData")
    @Expose
    private List<Object> pathVariableData = null;
    @SerializedName("queryParams")
    @Expose
    private List<Object> queryParams = null;
    @SerializedName("auth")
    @Expose
    private Object auth;
    @SerializedName("events")
    @Expose
    private List<Object> events = null;
    @SerializedName("folder")
    @Expose
    private Object folder;
    @SerializedName("currentHelper")
    @Expose
    private Object currentHelper;
    @SerializedName("helperAttributes")
    @Expose
    private Object helperAttributes;
    @SerializedName("collectionId")
    @Expose
    private String collectionId;
    @SerializedName("headers")
    @Expose
    private String headers;
    @SerializedName("pathVariables")
    @Expose
    private List<Object> pathVariables = null;
    @SerializedName("rawModeData")
    @Expose
    private String rawModeData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public String getDataMode() {
        return dataMode;
    }

    public void setDataMode(String dataMode) {
        this.dataMode = dataMode;
    }

    public List<HeaderDatum> getHeaderData() {
        return headerData;
    }

    public void setHeaderData(List<HeaderDatum> headerData) {
        this.headerData = headerData;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public List<Object> getPathVariableData() {
        return pathVariableData;
    }

    public void setPathVariableData(List<Object> pathVariableData) {
        this.pathVariableData = pathVariableData;
    }

    public List<Object> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(List<Object> queryParams) {
        this.queryParams = queryParams;
    }

    public Object getAuth() {
        return auth;
    }

    public void setAuth(Object auth) {
        this.auth = auth;
    }

    public List<Object> getEvents() {
        return events;
    }

    public void setEvents(List<Object> events) {
        this.events = events;
    }

    public Object getFolder() {
        return folder;
    }

    public void setFolder(Object folder) {
        this.folder = folder;
    }

    public Object getCurrentHelper() {
        return currentHelper;
    }

    public void setCurrentHelper(Object currentHelper) {
        this.currentHelper = currentHelper;
    }

    public Object getHelperAttributes() {
        return helperAttributes;
    }

    public void setHelperAttributes(Object helperAttributes) {
        this.helperAttributes = helperAttributes;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public List<Object> getPathVariables() {
        return pathVariables;
    }

    public void setPathVariables(List<Object> pathVariables) {
        this.pathVariables = pathVariables;
    }

    public String getRawModeData() {
        return rawModeData;
    }

    public void setRawModeData(String rawModeData) {
        this.rawModeData = rawModeData;
    }

}
