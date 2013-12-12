/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.altran.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "QUESTIONARY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Questionary.findAll", query = "SELECT q FROM Questionary q"),
    @NamedQuery(name = "Questionary.findByIdQuestionary", query = "SELECT q FROM Questionary q WHERE q.idQuestionary = :idQuestionary"),
    @NamedQuery(name = "Questionary.findByName", query = "SELECT q FROM Questionary q WHERE q.name = :name")})
public class Questionary implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_QUESTIONARY")
    private BigDecimal idQuestionary;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idQuestionary")
    private Collection<Question> questionCollection;

    public Questionary() {
    }

    public Questionary(BigDecimal idQuestionary) {
        this.idQuestionary = idQuestionary;
    }

    public Questionary(BigDecimal idQuestionary, String name) {
        this.idQuestionary = idQuestionary;
        this.name = name;
    }

    public BigDecimal getIdQuestionary() {
        return idQuestionary;
    }

    public void setIdQuestionary(BigDecimal idQuestionary) {
        this.idQuestionary = idQuestionary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Question> getQuestionCollection() {
        return questionCollection;
    }

    public void setQuestionCollection(Collection<Question> questionCollection) {
        this.questionCollection = questionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuestionary != null ? idQuestionary.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questionary)) {
            return false;
        }
        Questionary other = (Questionary) object;
        if ((this.idQuestionary == null && other.idQuestionary != null) || (this.idQuestionary != null && !this.idQuestionary.equals(other.idQuestionary))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pt.altran.entities.Questionary[ idQuestionary=" + idQuestionary + " ]";
    }
    
}
