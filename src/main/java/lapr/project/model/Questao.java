package lapr.project.model;

/**
 * A question with a text and an answer
 * @author Diana Silva
 */

public class Questao {
    private String pergunta;
    private int resposta;

    /**
       Constrói uma questão com pergunta sem texto e uma resposta igual a zero.
    */
    public Questao()
    {
        this.pergunta = "";
        this.resposta=0;
    }
    
    /**
       Define o texto da questão.
       @param questionText o texto da questão
    */
    public void setText(String questionText)
    {
        this.pergunta = questionText;
    }
    
    /**
     * Define o texto da questão.
     * @param criterio o texto da questão relativa ao critério
     */
    public void setQuestion(Criterio criterio) {
        this.pergunta= criterio.toString();
    }
    
    /**
     * Define a resposta da questão
     * @param answer a resposta à questão
     */
    public void setAnswer(int answer){
        if(answer>=0 && answer<=5){
            resposta=answer;
        }else{
            System.out.println("Resposta inválida.");
        }
    }

    /**
       Apresenta a questão
    */
    public void display()
    {
        System.out.println(pergunta);
    }
    
    
}
