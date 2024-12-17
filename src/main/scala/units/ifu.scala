package npc.units.iFetch

import chisel3._
import chisel3.util._
import npc.helper._
import npc.helper.defs.Base._
import npc.helper.defs.PipelineDefs.IF2ID_Width


class iFetchInternal extends Bundle {
  val iMasterReady = Input(Bool())
  val oMasterValid = Output(Bool())

  val iPC = Input(UInt(AddrWidth.W))

  val iFeedBackPCChanged = Input(Bool())
  val iFeedBackDecodingJump = Input(Bool())

  val iIDUDecodingBranch = Input(Bool())
  val iIDUDecodingJump = Input(Bool())

  val PipLine_IF2ID_MsgBundle = Output(UInt(IF2ID_Width.W))
  val PipLine_IF2ID_ChangeReg = Output(Bool())
}

class iFetchExternal extends Bundle {
  val iInst = Input(UInt(InstSize.W))
  val oPC = Output(UInt(AddrWidth.W))
  val oMemEnable = Output(Bool())
}

class IFU extends Module {
  val ioInternal = IO(new iFetchInternal)
  val ioExternal = IO(new iFetchExternal)

  val IFU_StateOK = ioInternal.iMasterReady.asBool

  ioExternal.oMemEnable := (IFU_StateOK) && (!ioInternal.iIDUDecodingBranch) &&  (!ioInternal.iFeedBackDecodingJump) && (!ioInternal.iFeedBackPCChanged) && (!ioInternal.iIDUDecodingJump) // && ioInternal.iPCHaveWB
  ioExternal.oPC := ioInternal.iPC
  ioInternal.oMasterValid := ((!ioInternal.iFeedBackPCChanged) && (!ioInternal.iIDUDecodingBranch) && ioInternal.iPC =/= 0.U) && (!ioInternal.iFeedBackDecodingJump) && (!ioInternal.iIDUDecodingJump)// && ioInternal.iPCHaveWB

  val Inst = Mux(IFU_StateOK, ioExternal.iInst, 0.U(InstWidth.W))
  val PC = ioInternal.iPC


}

