package com.obscured.squeeze4j.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "contributor_id",
        "contributor"
})
public class SearchContributors {

    @JsonProperty("contributor_id")
    private Integer contributorId;

    @JsonProperty("contributor")
    private String contributor;

    public Integer getContributorId() {
        return contributorId;
    }

    public void setContributorId(Integer contributorId) {
        this.contributorId = contributorId;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(contributorId).append(contributor).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof SearchContributors)) {
            return false;
        }
        SearchContributors rhs = ((SearchContributors) other);
        return new EqualsBuilder().append(contributorId, rhs.contributorId).append(contributor, rhs.contributor).isEquals();
    }

}

