/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package target.model;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import static com.querydsl.core.types.PathMetadataFactory.forVariable;
import com.querydsl.core.types.dsl.DateTimePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.EnumPath;
import com.querydsl.core.types.dsl.ListPath;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.StringPath;
import com.rest.warehouse.app.model.WareTransaction;
import com.rest.warehouse.app.model.WareTransactionDetail;
import javax.annotation.Generated;

/**
 *
 * @author Administrator
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QWareTransaction extends EntityPathBase<WareTransaction> {

    private static final long serialVersionUID = 2048052015L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QWareTransaction wareTransaction = new QWareTransaction("wareTransaction");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QStockClerk stockClerk;

    public final DateTimePath<java.time.LocalDateTime> transactionDate = createDateTime("transactionDate", java.time.LocalDateTime.class);

    public final ListPath<WareTransactionDetail, QWareTransactionDetail> wareTransactionDetails = this.<WareTransactionDetail, QWareTransactionDetail>createList("wareTransactionDetails", WareTransactionDetail.class, QWareTransactionDetail.class, PathInits.DIRECT2);

    public final EnumPath<com.rest.warehouse.app.enums.WareTransactionType> wareTransactionType = createEnum("wareTransactionType", com.rest.warehouse.app.enums.WareTransactionType.class);

    public QWareTransaction(String variable) {
        this(WareTransaction.class, forVariable(variable), INITS);
    }

    public QWareTransaction(Path<? extends WareTransaction> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QWareTransaction(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QWareTransaction(PathMetadata metadata, PathInits inits) {
        this(WareTransaction.class, metadata, inits);
    }

    public QWareTransaction(Class<? extends WareTransaction> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.stockClerk = inits.isInitialized("stockClerk") ? new QStockClerk(forProperty("stockClerk")) : null;
    }

}


