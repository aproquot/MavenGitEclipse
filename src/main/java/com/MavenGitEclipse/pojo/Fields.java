
package com.MavenGitEclipse.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nom_de_la_commune",
    "libell_d_acheminement",
    "code_postal",
    "coordonnees_gps",
    "code_commune_insee",
    "ligne_5"
})
public class Fields {

    @JsonProperty("nom_de_la_commune")
    private String nomDeLaCommune;
    @JsonProperty("libell_d_acheminement")
    private String libellDAcheminement;
    @JsonProperty("code_postal")
    private String codePostal;
    @JsonProperty("coordonnees_gps")
    private List<Double> coordonneesGps = null;
    @JsonProperty("code_commune_insee")
    private String codeCommuneInsee;
    @JsonProperty("ligne_5")
    private String ligne5;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("nom_de_la_commune")
    public String getNomDeLaCommune() {
        return nomDeLaCommune;
    }

    @JsonProperty("nom_de_la_commune")
    public void setNomDeLaCommune(String nomDeLaCommune) {
        this.nomDeLaCommune = nomDeLaCommune;
    }

    @JsonProperty("libell_d_acheminement")
    public String getLibellDAcheminement() {
        return libellDAcheminement;
    }

    @JsonProperty("libell_d_acheminement")
    public void setLibellDAcheminement(String libellDAcheminement) {
        this.libellDAcheminement = libellDAcheminement;
    }

    @JsonProperty("code_postal")
    public String getCodePostal() {
        return codePostal;
    }

    @JsonProperty("code_postal")
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    @JsonProperty("coordonnees_gps")
    public List<Double> getCoordonneesGps() {
        return coordonneesGps;
    }

    @JsonProperty("coordonnees_gps")
    public void setCoordonneesGps(List<Double> coordonneesGps) {
        this.coordonneesGps = coordonneesGps;
    }

    @JsonProperty("code_commune_insee")
    public String getCodeCommuneInsee() {
        return codeCommuneInsee;
    }

    @JsonProperty("code_commune_insee")
    public void setCodeCommuneInsee(String codeCommuneInsee) {
        this.codeCommuneInsee = codeCommuneInsee;
    }

    @JsonProperty("ligne_5")
    public String getLigne5() {
        return ligne5;
    }

    @JsonProperty("ligne_5")
    public void setLigne5(String ligne5) {
        this.ligne5 = ligne5;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
