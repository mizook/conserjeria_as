package cl.ucn.disc.as.model.query;

import cl.ucn.disc.as.model.Departamento;
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
import io.ebean.typequery.PString;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import java.util.function.Consumer;

/**
 * Query bean for Departamento.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean("v1")
public final class QDepartamento extends TQRootBean<Departamento,QDepartamento> {

  private static final QDepartamento _alias = new QDepartamento(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QDepartamento alias() {
    return _alias;
  }

  public PLong<QDepartamento> id;
  public PLong<QDepartamento> version;
  public PInstant<QDepartamento> created;
  public PInstant<QDepartamento> modified;
  public PLong<QDepartamento> edificioID;
  public PInteger<QDepartamento> numero;
  public PString<QDepartamento> piso;


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
  public static QDepartamento forFetchGroup() {
    return new QDepartamento(FetchGroup.queryFor(Departamento.class));
  }

  /** Construct using the default Database */
  public QDepartamento() {
    super(Departamento.class);
  }

  /** Construct with a given transaction */
  public QDepartamento(Transaction transaction) {
    super(Departamento.class, transaction);
  }

  /** Construct with a given Database */
  public QDepartamento(Database database) {
    super(Departamento.class, database);
  }


  /** Private constructor for Alias */
  private QDepartamento(boolean dummy) {
    super(dummy);
  }

  /** Private constructor for FetchGroup building */
  private QDepartamento(Query<Departamento> fetchGroupQuery) {
    super(fetchGroupQuery);
  }

  /** Private constructor for filterMany */
  private QDepartamento(ExpressionList<Departamento> filter) {
    super(filter);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  @Generated("io.ebean.querybean.generator")
  public static final class Alias {
    public static PLong<QDepartamento> id = _alias.id;
    public static PLong<QDepartamento> version = _alias.version;
    public static PInstant<QDepartamento> created = _alias.created;
    public static PInstant<QDepartamento> modified = _alias.modified;
    public static PLong<QDepartamento> edificioID = _alias.edificioID;
    public static PInteger<QDepartamento> numero = _alias.numero;
    public static PString<QDepartamento> piso = _alias.piso;
  }

  /**  Association query bean */
  @Generated("io.ebean.querybean.generator")
  @TypeQueryBean("v1")
  public static final class Assoc<R> extends TQAssocBean<Departamento,R,QDepartamento> {
    public PLong<R> id;
    public PLong<R> version;
    public PInstant<R> created;
    public PInstant<R> modified;
    public PLong<R> edificioID;
    public PInteger<R> numero;
    public PString<R> piso;

    public Assoc(String name, R root) {
      super(name, root);
    }

    public Assoc(String name, R root, String prefix) {
      super(name, root, prefix);
    }
    public final R filterMany(Consumer<QDepartamento> apply) {
      final ExpressionList list = Expr.factory().expressionList();
      final var qb = new QDepartamento(list);
      apply.accept(qb);
      expr().filterMany(_name).addAll(list);
      return _root;
    }
  }
}
