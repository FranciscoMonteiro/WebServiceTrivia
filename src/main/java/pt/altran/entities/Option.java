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
@Table(name = "OPTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Option.findAll", query = "SELECT o FROM Option o"),
    @NamedQuery(name = "Option.findByIdOption", query = "SELECT o FROM Option o WHERE o.idOption = :idOption"),
    @NamedQuery(name = "Option.findByOptionContent", query = "SELECT o FROM Option o WHERE o.optionContent = :optionContent")})
public class Option implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_OPTION")
    private BigDecimal idOption;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "OPTION_CONTENT")
    private String optionContent;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOption")
    private Collection<Answer> answerCollection;

    public Option() {
    }

    public Option(BigDecimal idOption) {
        this.idOption = idOption;
    }

    public Option(BigDecimal idOption, String optionContent) {
        this.idOption = idOption;
        this.optionContent = optionContent;
    }

    public BigDecimal getIdOption() {
        return idOption;
    }

    public void setIdOption(BigDecimal idOption) {
        this.idOption = idOption;
    }

    public String getOptionContent() {
        return optionContent;
    }

    public void setOptionContent(String optionContent) {
        this.optionContent = optionContent;
    }

    @XmlTransient
    public Collection<Answer> getAnswerCollection() {
        return answerCollection;
    }

    public void setAnswerCollection(Collection<Answer> answerCollection) {
        this.answerCollection = answerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOption != null ? idOption.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Option)) {
            return false;
        }
        Option other = (Option) object;
        if ((this.idOption == null && other.idOption != null) || (this.idOption != null && !this.idOption.equals(other.idOption))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pt.altran.entities.Option[ idOption=" + idOption + " ]";
    }
    
}
