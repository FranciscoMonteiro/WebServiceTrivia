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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "QUESTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
    @NamedQuery(name = "Question.findByQuestionContent", query = "SELECT q FROM Question q WHERE q.questionContent = :questionContent"),
    @NamedQuery(name = "Question.findByIdQuestion", query = "SELECT q FROM Question q WHERE q.idQuestion = :idQuestion")})
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "QUESTION_CONTENT")
    private String questionContent;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_QUESTION")
    private BigDecimal idQuestion;
    @JoinColumn(name = "ID_QUESTIONARY", referencedColumnName = "ID_QUESTIONARY")
    @ManyToOne(optional = false)
    private Questionary idQuestionary;

    public Question() {
    }

    public Question(BigDecimal idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Question(BigDecimal idQuestion, String questionContent) {
        this.idQuestion = idQuestion;
        this.questionContent = questionContent;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public BigDecimal getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(BigDecimal idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Questionary getIdQuestionary() {
        return idQuestionary;
    }

    public void setIdQuestionary(Questionary idQuestionary) {
        this.idQuestionary = idQuestionary;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuestion != null ? idQuestion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.idQuestion == null && other.idQuestion != null) || (this.idQuestion != null && !this.idQuestion.equals(other.idQuestion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pt.altran.entities.Question[ idQuestion=" + idQuestion + " ]";
    }
    
}
