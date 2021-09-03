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
import com.querydsl.core.types.dsl.StringPath;
import com.rest.warehouse.app.model.StockClerk;
import javax.annotation.Generated;

/**
 *
 * @author Administrator
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStockClerk extends EntityPathBase<StockClerk> {

    private static final long serialVersionUID = 801717009L;

    public static final QStockClerk stockClerk = new QStockClerk("stockClerk");

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath lastName = createString("lastName");

    public final StringPath registryNumber = createString("registryNumber");

    public QStockClerk(String variable) {
        super(StockClerk.class, forVariable(variable));
    }

    public QStockClerk(Path<? extends StockClerk> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStockClerk(PathMetadata metadata) {
        super(StockClerk.class, metadata);
    }

}

