package cl.ucn.disc.as.model.query;

import cl.ucn.disc.as.model.Pago;
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
 * Query bean for Pago.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean("v1")
public final class QPago extends TQRootBean<Pago,QPago> {

  private static final QPago _alias = new QPago(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QPago alias() {
    return _alias;
  }

  public PLong<QPago> id;
  public PLong<QPago> version;
  public PInstant<QPago> created;
  public PInstant<QPago> modified;
  public QContrato.Assoc<QPago> contrato;
  public PInstant<QPago> fechaPago;
  public PInteger<QPago> monto;


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
  public static QPago forFetchGroup() {
    return new QPago(FetchGroup.queryFor(Pago.class));
  }

  /** Construct using the default Database */
  public QPago() {
    super(Pago.class);
  }

  /** Construct with a given transaction */
  public QPago(Transaction transaction) {
    super(Pago.class, transaction);
  }

  /** Construct with a given Database */
  public QPago(Database database) {
    super(Pago.class, database);
  }


  /** Private constructor for Alias */
  private QPago(boolean dummy) {
    super(dummy);
  }

  /** Private constructor for FetchGroup building */
  private QPago(Query<Pago> fetchGroupQuery) {
    super(fetchGroupQuery);
  }

  /** Private constructor for filterMany */
  private QPago(ExpressionList<Pago> filter) {
    super(filter);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  @Generated("io.ebean.querybean.generator")
  public static final class Alias {
    public static PLong<QPago> id = _alias.id;
    public static PLong<QPago> version = _alias.version;
    public static PInstant<QPago> created = _alias.created;
    public static PInstant<QPago> modified = _alias.modified;
    public static QContrato.Assoc<QPago> contrato = _alias.contrato;
    public static PInstant<QPago> fechaPago = _alias.fechaPago;
    public static PInteger<QPago> monto = _alias.monto;
  }

  /**  Association query bean */
  @Generated("io.ebean.querybean.generator")
  @TypeQueryBean("v1")
  public static final class Assoc<R> extends TQAssocBean<Pago,R,QPago> {
    public PLong<R> id;
    public PLong<R> version;
    public PInstant<R> created;
    public PInstant<R> modified;
    public QContrato.Assoc<R> contrato;
    public PInstant<R> fechaPago;
    public PInteger<R> monto;

    public Assoc(String name, R root) {
      super(name, root);
    }

    public Assoc(String name, R root, String prefix) {
      super(name, root, prefix);
    }
    public final R filterMany(Consumer<QPago> apply) {
      final ExpressionList list = Expr.factory().expressionList();
      final var qb = new QPago(list);
      apply.accept(qb);
      expr().filterMany(_name).addAll(list);
      return _root;
    }
  }
}
