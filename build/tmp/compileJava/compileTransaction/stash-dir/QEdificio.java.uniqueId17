package cl.ucn.disc.as.model.query;

import cl.ucn.disc.as.model.Edificio;
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
 * Query bean for Edificio.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean("v1")
public final class QEdificio extends TQRootBean<Edificio,QEdificio> {

  private static final QEdificio _alias = new QEdificio(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QEdificio alias() {
    return _alias;
  }

  public PLong<QEdificio> id;
  public PLong<QEdificio> version;
  public PInstant<QEdificio> created;
  public PInstant<QEdificio> modified;
  public PString<QEdificio> constructora;
  public PString<QEdificio> nombre;
  public PString<QEdificio> direccion;
  public PInteger<QEdificio> pisos;


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
  public static QEdificio forFetchGroup() {
    return new QEdificio(FetchGroup.queryFor(Edificio.class));
  }

  /** Construct using the default Database */
  public QEdificio() {
    super(Edificio.class);
  }

  /** Construct with a given transaction */
  public QEdificio(Transaction transaction) {
    super(Edificio.class, transaction);
  }

  /** Construct with a given Database */
  public QEdificio(Database database) {
    super(Edificio.class, database);
  }


  /** Private constructor for Alias */
  private QEdificio(boolean dummy) {
    super(dummy);
  }

  /** Private constructor for FetchGroup building */
  private QEdificio(Query<Edificio> fetchGroupQuery) {
    super(fetchGroupQuery);
  }

  /** Private constructor for filterMany */
  private QEdificio(ExpressionList<Edificio> filter) {
    super(filter);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  @Generated("io.ebean.querybean.generator")
  public static final class Alias {
    public static PLong<QEdificio> id = _alias.id;
    public static PLong<QEdificio> version = _alias.version;
    public static PInstant<QEdificio> created = _alias.created;
    public static PInstant<QEdificio> modified = _alias.modified;
    public static PString<QEdificio> constructora = _alias.constructora;
    public static PString<QEdificio> nombre = _alias.nombre;
    public static PString<QEdificio> direccion = _alias.direccion;
    public static PInteger<QEdificio> pisos = _alias.pisos;
  }

  /**  Association query bean */
  @Generated("io.ebean.querybean.generator")
  @TypeQueryBean("v1")
  public static final class Assoc<R> extends TQAssocBean<Edificio,R,QEdificio> {
    public PLong<R> id;
    public PLong<R> version;
    public PInstant<R> created;
    public PInstant<R> modified;
    public PString<R> constructora;
    public PString<R> nombre;
    public PString<R> direccion;
    public PInteger<R> pisos;

    public Assoc(String name, R root) {
      super(name, root);
    }

    public Assoc(String name, R root, String prefix) {
      super(name, root, prefix);
    }
    public final R filterMany(Consumer<QEdificio> apply) {
      final ExpressionList list = Expr.factory().expressionList();
      final var qb = new QEdificio(list);
      apply.accept(qb);
      expr().filterMany(_name).addAll(list);
      return _root;
    }
  }
}
