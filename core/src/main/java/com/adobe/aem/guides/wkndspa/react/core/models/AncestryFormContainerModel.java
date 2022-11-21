package com.adobe.aem.guides.wkndspa.react.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.List;

/**
 * Sling Model to map FormContainer elements for global validation script.
 */
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class AncestryFormContainerModel {
    private final String ERROR_KEY = "errorMessage";
    private final String LOCATION_KEY = "errorLocation";
    private final String PATTERN_KEY = "pattern";
    private final String REQUIRED_KEY = "required";
    private final String ELEMENT_RESOURCE = "element";

    @ChildResource(name = ELEMENT_RESOURCE )
    private List<FormElement> formElement;

    public List<FormElement> getFormElement() {
        return formElement;
    }

    public void setFormElement(List<FormElement> formElement) {
        this.formElement = formElement;
    }

    /**
     * @return JSONString equivalent of field object required in Global Script Validation.
     */
    public String getFields() {
        JSONObject fieldObj = new JSONObject();
        formElement.forEach((element)->{
            JSONObject input = new JSONObject();
            try {
                input.put(ERROR_KEY, element.getErrorMessage());
                input.put(LOCATION_KEY, element.getErrorLocation());
                input.put(PATTERN_KEY, element.getPattern());
                input.put(REQUIRED_KEY, Boolean.parseBoolean(element.getRequired()));
                fieldObj.put(element.getInputId(),input);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
      return fieldObj.toString();
    }
}
