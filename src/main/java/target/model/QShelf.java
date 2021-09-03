/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package target.model;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import static com.querydsl.core.types.PathMetadataFactory.forVariable;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.StringPath;
import com.rest.warehouse.app.model.Shelf;
import javax.annotation.Generated;

/**
 *
 * @author Administrator
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QShelf extends EntityPathBase<Shelf> {

    private static final long serialVersionUID = 1956027064L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QShelf shelf = new QShelf("shelf");

    public final StringPath code = createString("code");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QWarehouse warehouse;

    public QShelf(String variable) {
        this(Shelf.class, forVariable(variable), INITS);
    }

    public QShelf(Path<? extends Shelf> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QShelf(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QShelf(PathMetadata metadata, PathInits inits) {
        this(Shelf.class, metadata, inits);
    }

    public QShelf(Class<? extends Shelf> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.warehouse = inits.isInitialized("warehouse") ? new QWarehouse(forProperty("warehouse")) : null;
    }

}

