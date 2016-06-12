package lapr.project.model.mechanisms;

import java.util.Objects;

/**
 *
 * @author Pedro Fernandes
 */
public class TipoConflito {

    private String descricao;
    private MecanismoDetecaoConflito mecanismo;

    public TipoConflito() {
    }

    public TipoConflito(String descricao, MecanismoDetecaoConflito mecanismo) {
        this.descricao = descricao;
        this.mecanismo = mecanismo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public MecanismoDetecaoConflito getMecanismoDetecaoConflito() {
        return mecanismo;
    }

    public void setMecanismoDetecaoConflito(MecanismoDetecaoConflito mecanismo) {
        this.mecanismo = mecanismo;
    }

    /**
     * Valida tipo de conflito, se a descrição e mecanismos estão preenchidos.
     *
     * @return boolean valido ou não
     */
    public boolean valida() {
        return !(descricao == null || mecanismo == null);
    }

    @Override
    public String toString() {
        return getDescricao() + " - " + getMecanismoDetecaoConflito().toString();
    }

    /**
     * Verifica se o objeto passado por parametro é igual ao objeto instanciado.
     *
     * @param obj a verificar
     * @return boolean igual ou não
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof TipoConflito) {
            TipoConflito tc = (TipoConflito) obj;
            if (tc.getDescricao().equals(descricao)
                    && tc.getMecanismoDetecaoConflito().equals(mecanismo)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.descricao);
        return hash;
    }
}
