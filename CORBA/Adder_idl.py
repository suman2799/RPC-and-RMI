# Python stubs generated by omniidl from Adder.idl
# DO NOT EDIT THIS FILE!

import omniORB, _omnipy
from omniORB import CORBA, PortableServer
_0_CORBA = CORBA


_omnipy.checkVersion(4,2, __file__, 1)

try:
    property
except NameError:
    def property(*args):
        return None


#
# Start of module "Math"
#
__name__ = "Math"
_0_Math = omniORB.openModule("Math", r"Adder.idl")
_0_Math__POA = omniORB.openModule("Math__POA", r"Adder.idl")


# interface Adder
_0_Math._d_Adder = (omniORB.tcInternal.tv_objref, "IDL:Math/Adder:1.0", "Adder")
omniORB.typeMapping["IDL:Math/Adder:1.0"] = _0_Math._d_Adder
_0_Math.Adder = omniORB.newEmptyClass()
class Adder :
    _NP_RepositoryId = _0_Math._d_Adder[1]

    def __init__(self, *args, **kw):
        raise RuntimeError("Cannot construct objects of this type.")

    _nil = CORBA.Object._nil


_0_Math.Adder = Adder
_0_Math._tc_Adder = omniORB.tcInternal.createTypeCode(_0_Math._d_Adder)
omniORB.registerType(Adder._NP_RepositoryId, _0_Math._d_Adder, _0_Math._tc_Adder)

# Adder operations and attributes
Adder._d_add = ((omniORB.tcInternal.tv_long, omniORB.tcInternal.tv_long), (omniORB.tcInternal.tv_long, ), None)

# Adder object reference
class _objref_Adder (CORBA.Object):
    _NP_RepositoryId = Adder._NP_RepositoryId

    def __init__(self, obj):
        CORBA.Object.__init__(self, obj)

    def add(self, *args):
        return self._obj.invoke("add", _0_Math.Adder._d_add, args)

omniORB.registerObjref(Adder._NP_RepositoryId, _objref_Adder)
_0_Math._objref_Adder = _objref_Adder
del Adder, _objref_Adder

# Adder skeleton
__name__ = "Math__POA"
class Adder (PortableServer.Servant):
    _NP_RepositoryId = _0_Math.Adder._NP_RepositoryId


    _omni_op_d = {"add": _0_Math.Adder._d_add}

Adder._omni_skeleton = Adder
_0_Math__POA.Adder = Adder
omniORB.registerSkeleton(Adder._NP_RepositoryId, Adder)
del Adder
__name__ = "Math"

#
# End of module "Math"
#
__name__ = "Adder_idl"

_exported_modules = ( "Math", )

# The end.