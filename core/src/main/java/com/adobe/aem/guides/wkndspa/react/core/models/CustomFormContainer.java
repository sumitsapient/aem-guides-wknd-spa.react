package com.adobe.aem.guides.wkndspa.react.core.models;

import com.adobe.cq.export.json.ContainerExporter;
import com.adobe.cq.wcm.core.components.models.form.Container;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.via.ResourceSuperType;

@Model(adaptables = SlingHttpServletRequest.class, adapters = {Container.class, ContainerExporter.class}, resourceType = {"core/wcm/components/form/container/v1/container", "core/wcm/components/form/container/v2/container"},defaultInjectionStrategy= DefaultInjectionStrategy.OPTIONAL)
@Exporter(
        name = "jackson",
        extensions = {"json"}
)
public class CustomFormContainer implements Container {
    @Self
    @Via(type = ResourceSuperType.class)
    private Container container;

    @Override public String getId() {
        return "sumit";
    }
    @Override public String getMethod() {
        return container.getMethod();
    }

    @Override public String getAction() {
        return container.getAction();
    }

    @Override public String getName() {
        return container.getName();
    }

    @Override public String getEnctype() {
        return container.getEnctype();
    }

}
