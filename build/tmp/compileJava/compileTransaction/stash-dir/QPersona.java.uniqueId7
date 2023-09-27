package cl.ucn.disc.as.model.query;

import cl.ucn.disc.as.model.Persona;
import io.ebean.Database;
import io.ebean.Expr;
import io.ebean.ExpressionList;
import io.ebean.FetchGroup;
import io.ebean.Query;
import io.ebean.Transaction;
import io.ebean.typequery.Generated;
import io.ebean.typequery.PInstant;
import io.ebean.typequery.PLong;
import io.ebean.typequery.PString;
import io.ebean.typequery.TQAssocBean;
import io.ebean.typequery.TQRootBean;
import io.ebean.typequery.TypeQueryBean;
import java.util.function.Consumer;

/**
 * Query bean for Persona.
 * 
 * THIS IS A GENERATED OBJECT, DO NOT MODIFY THIS CLASS.
 */
@Generated("io.ebean.querybean.generator")
@TypeQueryBean("v1")
public final class QPersona extends TQRootBean<Persona,QPersona> {

  private static final QPersona _alias = new QPersona(true);

  /**
   * Return the shared 'Alias' instance used to provide properties to 
   * <code>select()</code> and <code>fetch()</code> 
   */
  public static QPersona alias() {
    return _alias;
  }

  public PLong<QPersona> id;
  public PLong<QPersona> version;
  public PInstant<QPersona> created;
  public PInstant<QPersona> modified;
  public PString<QPersona> rut;
  public PString<QPersona> nombre;
  public PString<QPersona> apellidos;
  public PString<QPersona> email;
  public PString<QPersona> telefono;


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
  public static QPersona forFetchGroup() {
    return new QPersona(FetchGroup.queryFor(Persona.class));
  }

  /** Construct using the default Database */
  public QPersona() {
    super(Persona.class);
  }

  /** Construct with a given transaction */
  public QPersona(Transaction transaction) {
    super(Persona.class, transaction);
  }

  /** Construct with a given Database */
  public QPersona(Database database) {
    super(Persona.class, database);
  }


  /** Private constructor for Alias */
  private QPersona(boolean dummy) {
    super(dummy);
  }

  /** Private constructor for FetchGroup building */
  private QPersona(Query<Persona> fetchGroupQuery) {
    super(fetchGroupQuery);
  }

  /** Private constructor for filterMany */
  private QPersona(ExpressionList<Persona> filter) {
    super(filter);
  }

  /**
   * Provides static properties to use in <em> select() and fetch() </em>
   * clauses of a query. Typically referenced via static imports. 
   */
  @Generated("io.ebean.querybean.generator")
  public static final class Alias {
    public static PLong<QPersona> id = _alias.id;
    public static PLong<QPersona> version = _alias.version;
    public static PInstant<QPersona> created = _alias.created;
    public static PInstant<QPersona> modified = _alias.modified;
    public static PString<QPersona> rut = _alias.rut;
    public static PString<QPersona> nombre = _alias.nombre;
    public static PString<QPersona> apellidos = _alias.apellidos;
    public static PString<QPersona> email = _alias.email;
    public static PString<QPersona> telefono = _alias.telefono;
  }

  /**  Association query bean */
  @Generated("io.ebean.querybean.generator")
  @TypeQueryBean("v1")
  public static final class Assoc<R> extends TQAssocBean<Persona,R,QPersona> {
    public PLong<R> id;
    public PLong<R> version;
    public PInstant<R> created;
    public PInstant<R> modified;
    public PString<R> rut;
    public PString<R> nombre;
    public PString<R> apellidos;
    public PString<R> email;
    public PString<R> telefono;

    public Assoc(String name, R root) {
      super(name, root);
    }

    public Assoc(String name, R root, String prefix) {
      super(name, root, prefix);
    }
    public final R filterMany(Consumer<QPersona> apply) {
      final ExpressionList list = Expr.factory().expressionList();
      final var qb = new QPersona(list);
      apply.accept(qb);
      expr().filterMany(_name).addAll(list);
      return _root;
    }
  }
}
