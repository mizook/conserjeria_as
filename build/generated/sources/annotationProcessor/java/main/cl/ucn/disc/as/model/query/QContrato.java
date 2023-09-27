package cl.ucn.disc.as.model.query;

import cl.ucn.disc.as.model.Contrato;
import io.ebean.Database;
import io.ebean.Expr;
import io.ebean.ExpressionList;
import io.ebean.FetchGroup;
import io.ebean.Query;
import io.ebean.Transaction;
import io.ebean.typequery.Generated;
import io.ebean.typequery.PInstant;
import io.ebean.typequery.PInteger;
import io.ebean.typequery.PLong;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import java.util.function.Consumer;

/**
 * Query bean for Contrato.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean("v1")
public final class QContrato extends TQRootBean<Contrato,QContrato> {

  private static final QContrato _alias = new QContrato(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QContrato alias() {
    return _alias;
  }

  public PLong<QContrato> id;
  public PLong<QContrato> version;
  public PInstant<QContrato> created;
  public PInstant<QContrato> modified;
  public PLong<QContrato> edificioId;
  public PLong<QContrato> personaID;
  public PInstant<QContrato> pago;
  public PInteger<QContrato> monto;


  /**
   * Return a query bean used to build a FetchGroup.
   * <p>
   * FetchGroups are immutable and threadsafe and can be used by many
   * concurrent queries. We typically stored FetchGroup as a static final field.
   * <p>
   * Example creating and using a FetchGroup.
   * <pre>{@code
   * 
   * static final FetchGroup<Customer> fetchGroup = 
   *   QCustomer.forFetchGroup()
   *     .shippingAddress.fetch()
   *     .contacts.fetch()
   *     .buildFetchGroup();
   * 
   * List<Customer> customers = new QCustomer()
   *   .select(fetchGroup)
   *   .findList();
   * 
   * }</pre>
   */
  public static QContrato forFetchGroup() {
    return new QContrato(FetchGroup.queryFor(Contrato.class));
  }

  /** Construct using the default Database */
  public QContrato() {
    super(Contrato.class);
  }

  /** Construct with a given transaction */
  public QContrato(Transaction transaction) {
    super(Contrato.class, transaction);
  }

  /** Construct with a given Database */
  public QContrato(Database database) {
    super(Contrato.class, database);
  }


  /** Private constructor for Alias */
  private QContrato(boolean dummy) {
    super(dummy);
  }

  /** Private constructor for FetchGroup building */
  private QContrato(Query<Contrato> fetchGroupQuery) {
    super(fetchGroupQuery);
  }

  /** Private constructor for filterMany */
  private QContrato(ExpressionList<Contrato> filter) {
    super(filter);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  @Generated("io.ebean.querybean.generator")
  public static final class Alias {
    public static PLong<QContrato> id = _alias.id;
    public static PLong<QContrato> version = _alias.version;
    public static PInstant<QContrato> created = _alias.created;
    public static PInstant<QContrato> modified = _alias.modified;
    public static PLong<QContrato> edificioId = _alias.edificioId;
    public static PLong<QContrato> personaID = _alias.personaID;
    public static PInstant<QContrato> pago = _alias.pago;
    public static PInteger<QContrato> monto = _alias.monto;
  }

  /**  Association query bean */
  @Generated("io.ebean.querybean.generator")
  @TypeQueryBean("v1")
  public static final class Assoc<R> extends TQAssocBean<Contrato,R,QContrato> {
    public PLong<R> id;
    public PLong<R> version;
    public PInstant<R> created;
    public PInstant<R> modified;
    public PLong<R> edificioId;
    public PLong<R> personaID;
    public PInstant<R> pago;
    public PInteger<R> monto;

    public Assoc(String name, R root) {
      super(name, root);
    }

    public Assoc(String name, R root, String prefix) {
      super(name, root, prefix);
    }
    public final R filterMany(Consumer<QContrato> apply) {
      final ExpressionList list = Expr.factory().expressionList();
      final var qb = new QContrato(list);
      apply.accept(qb);
      expr().filterMany(_name).addAll(list);
      return _root;
    }
  }
}
