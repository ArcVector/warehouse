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
import com.querydsl.core.types.dsl.ListPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.StringPath;
import com.rest.warehouse.app.model.Shelf;
import com.rest.warehouse.app.model.Warehouse;
import javax.annotation.Generated;

/**
 *
 * @author Administrator
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWarehouse extends EntityPathBase<Warehouse> {

    private static final long serialVersionUID = -606896047L;

    public static final QWarehouse warehouse = new QWarehouse("warehouse");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<Shelf, QShelf> shelves = this.<Shelf, QShelf>createList("shelves", Shelf.class, QShelf.class, PathInits.DIRECT2);

    public QWarehouse(String variable) {
        super(Warehouse.class, forVariable(variable));
    }

    public QWarehouse(Path<? extends Warehouse> path) {
        super(path.getType(), path.getMetadata());
    }

    public QWarehouse(PathMetadata metadata) {
        super(Warehouse.class, metadata);
    }

}


