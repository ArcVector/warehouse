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
import com.rest.warehouse.app.model.Stock;
import javax.annotation.Generated;

/**
 *
 * @author Administrator
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStock extends EntityPathBase<Stock> {

    private static final long serialVersionUID = 1956393892L;

    public static final QStock stock = new QStock("stock");

    public final StringPath id = createString("id");

    public final StringPath productCode = createString("productCode");

    public final NumberPath<Long> productId = createNumber("productId", Long.class);

    public final StringPath shelfCode = createString("shelfCode");

    public final NumberPath<Long> shelfId = createNumber("shelfId", Long.class);

    public final NumberPath<Long> totalQuantity = createNumber("totalQuantity", Long.class);

    public final StringPath warehouseDescription = createString("warehouseDescription");

    public final NumberPath<Long> warehouseId = createNumber("warehouseId", Long.class);

    public QStock(String variable) {
        super(Stock.class, forVariable(variable));
    }

    public QStock(Path<? extends Stock> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStock(PathMetadata metadata) {
        super(Stock.class, metadata);
    }

}

