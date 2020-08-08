package br.com.cliente.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author vinny em 07/08/2020
 * @project cliente
 **/

@MappedSuperclass
public abstract class AbstractModel<Long extends Serializable> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "versao", length = 5)
    private String versao;

    @Column(name = "datacriacao")
    private Date dataCriacao;


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AbstractModel<?> abstractMidel = (AbstractModel<?>) obj;
        if (id == null) {
            if (abstractMidel.id != null)
                return false;
        } else if (!id.equals(abstractMidel.id))
            return false;
        return true;
    }
}
