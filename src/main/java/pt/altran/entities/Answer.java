/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.altran.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "ANSWER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Answer.findAll", query = "SELECT a FROM Answer a"),
    @NamedQuery(name = "Answer.findByIdAnswer", query = "SELECT a FROM Answer a WHERE a.idAnswer = :idAnswer")})
public class Answer implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ANSWER")
    private BigDecimal idAnswer;
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    @ManyToOne(optional = false)
    private Tuser idUser;
    @JoinColumn(name = "ID_OPTION", referencedColumnName = "ID_OPTION")
    @ManyToOne(optional = false)
    private Option idOption;

    public Answer() {
    }

    public Answer(BigDecimal idAnswer) {
        this.idAnswer = idAnswer;
    }

    public BigDecimal getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(BigDecimal idAnswer) {
        this.idAnswer = idAnswer;
    }

    public Tuser getIdUser() {
        return idUser;
    }

    public void setIdUser(Tuser idUser) {
        this.idUser = idUser;
    }

    public Option getIdOption() {
        return idOption;
    }

    public void setIdOption(Option idOption) {
        this.idOption = idOption;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnswer != null ? idAnswer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Answer)) {
            return false;
        }
        Answer other = (Answer) object;
        if ((this.idAnswer == null && other.idAnswer != null) || (this.idAnswer != null && !this.idAnswer.equals(other.idAnswer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pt.altran.entities.Answer[ idAnswer=" + idAnswer + " ]";
    }
}
