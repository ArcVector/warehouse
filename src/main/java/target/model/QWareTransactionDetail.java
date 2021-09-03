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
import com.rest.warehouse.app.model.WareTransactionDetail;
import javax.annotation.Generated;

/**
 *
 * @author Administrator
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWareTransactionDetail extends EntityPathBase<WareTransactionDetail> {

    private static final long serialVersionUID = -442339232L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWareTransactionDetail wareTransactionDetail = new QWareTransactionDetail("wareTransactionDetail");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QProduct product;

    public final NumberPath<Long> quantity = createNumber("quantity", Long.class);

    public final QShelf shelf;

    public final QWareTransaction wareTransaction;

    public QWareTransactionDetail(String variable) {
        this(WareTransactionDetail.class, forVariable(variable), INITS);
    }

    public QWareTransactionDetail(Path<? extends WareTransactionDetail> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWareTransactionDetail(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWareTransactionDetail(PathMetadata metadata, PathInits inits) {
        this(WareTransactionDetail.class, metadata, inits);
    }

    public QWareTransactionDetail(Class<? extends WareTransactionDetail> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product")) : null;
        this.shelf = inits.isInitialized("shelf") ? new QShelf(forProperty("shelf"), inits.get("shelf")) : null;
        this.wareTransaction = inits.isInitialized("wareTransaction") ? new QWareTransaction(forProperty("wareTransaction"), inits.get("wareTransaction")) : null;
    }

}

