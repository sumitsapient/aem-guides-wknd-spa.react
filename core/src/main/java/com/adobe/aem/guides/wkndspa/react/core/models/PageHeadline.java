package com.adobe.aem.guides.wkndspa.react.core.models;

import com.adobe.cq.wcm.core.components.models.Title;
import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.via.ResourceSuperType;

@Model(adaptables = SlingHttpServletRequest.class, adapters = Title.class, resourceType = "wknds/components/content/pageheadline")
public class PageHeadline implements Title {

    @ScriptVariable
    private Page currentPage;

    @Self
    @Via(type = ResourceSuperType.class)
    private Title title;

    @Override
    public String getText() {
        return currentPage.getTitle();
    }

    @Override
    public String getType() {
        return title.getType();
    }

}

