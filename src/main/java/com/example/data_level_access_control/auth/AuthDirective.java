package com.example.data_level_access_control.auth;

public class AuthDirective {
}
//
//class AuthDirective extends SchemaDirectiveVisitor {
//  /**
//   *
//   * @param {*} type
//   * @description
//   * Queries and mutations are treated differently by
//   * schema directives and so we need to check what the
//   * incoming type is.
//   *
//   * A field type is simply a field on a type. Things like
//   * `isBanned` may only be viewed by admins for example. We then
//   * check whether the correct role is present, and return
//   * the field if so.
//   *
//   * It is trickier with an object type which is typically
//   * used for mutations. Also, a type may have a default
//   * value for a schema directive but sub-fields may contain
//   * different types.
//   *
//   * We want to avoid re-wrapping the resolver, so we run a quick
//   * check for the type here and mark the fields as wrapped by
//   * using the `ensureFieldsWrapped` method.
//   *
//   * @see https://www.apollographql.com/docs/graphql-tools/schema-directives/
//   */
//  visitObject(type) {
//    this.ensureFieldsWrapped(type)
//    type._requiredAuthRole = this.args.type.toLowerCase()
//  }
//
//  // Visitor methods for nested types like fields and arguments
//  // also receive a details object that provides information about
//  // the parent and grandparent types.
//  visitFieldDefinition(field, details) {
//    this.ensureFieldsWrapped(details.objectType)
//    field._requiredAuthRole = this.args.type.toLowerCase()
//  }
//
//  ensureFieldsWrapped(objectType) {
//    // Mark the GraphQLObjectType object to avoid re-wrapping:
//    if (objectType._authFieldsWrapped) return
//        objectType._authFieldsWrapped = true
//
//    const fields = objectType.getFields()
//
//    Object.keys(fields).forEach((fieldName) => {
//      const field = fields[fieldName]
//      const { resolve = defaultFieldResolver } = field
//    field.resolve = async function (...args) {
//      // Get the required Role from the field first, falling back
//      // to the objectType if no Role is required by the field:
//        const requiredRole =
//          field._requiredAuthRole || objectType._requiredAuthRole
//
//      if (!requiredRole) {
//        return resolve.apply(this, args)
//      }
//
//        const context = args[2]
//        const user = context.req.user || {}
//
//        const userRole = await getUserRole()
//
//      if (user.UserRoleId !== userRole.id) {
//        throw new Error(
//            `You need following role: ${requiredRole}`,
//          )
//      }
//
//      return resolve.apply(this, args)
//    }
//    })
//  }
//}