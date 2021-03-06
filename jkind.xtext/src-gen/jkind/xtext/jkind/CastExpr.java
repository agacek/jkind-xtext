/**
 */
package jkind.xtext.jkind;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cast Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link jkind.xtext.jkind.CastExpr#getOp <em>Op</em>}</li>
 *   <li>{@link jkind.xtext.jkind.CastExpr#getExpr <em>Expr</em>}</li>
 * </ul>
 * </p>
 *
 * @see jkind.xtext.jkind.JkindPackage#getCastExpr()
 * @model
 * @generated
 */
public interface CastExpr extends Expr
{
  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see #setOp(String)
   * @see jkind.xtext.jkind.JkindPackage#getCastExpr_Op()
   * @model
   * @generated
   */
  String getOp();

  /**
   * Sets the value of the '{@link jkind.xtext.jkind.CastExpr#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see #getOp()
   * @generated
   */
  void setOp(String value);

  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(Expr)
   * @see jkind.xtext.jkind.JkindPackage#getCastExpr_Expr()
   * @model containment="true"
   * @generated
   */
  Expr getExpr();

  /**
   * Sets the value of the '{@link jkind.xtext.jkind.CastExpr#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expr value);

} // CastExpr
