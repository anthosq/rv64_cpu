package npc.helper.defs

import chisel3._

object Base {
  val DataWidth = 32
  val WordWidth = 32
  val HalfWordWidth = 16
  val ByteWidth = 8

  val InstWidth = 32
  val InstSize = 4

  val AddrWidth = 32

  val RegIDWidth = 5
  val RegSum = 16
  val CSRIDWidth = 12

  val iDecPrivValLen = 2
  val iDecEXUValLen = 7
  val iDecLSlenValLen = 2
  val iDecLSfuncValLen = 2
  val iDecWBTypValLen = 2
  val iDecDSValLen = 1
  val DecodeWidth = iDecPrivValLen + iDecEXUValLen + iDecLSlenValLen +
   iDecLSfuncValLen + iDecWBTypValLen + iDecDSValLen

  val InstTypeWidth = 4

  val immILen = 12
  val immSLen = 12
  val immBLen = 13
  val immULen = 32
  val immJLen = 21

  val RS1Hi = 19
  val RS1Lo = 15

  val RS2Hi = 24
  val RS2Lo = 20

  val RDHi = 11
  val RDLo = 7
}

object PipelineDefs {
  val IF2ID_Width = Base.InstWidth + Base.AddrWidth
  
  // EX have 2 SRC, LS have 1 SRC
  val ID2EX_Width = Base.InstWidth + 2 * Base.AddrWidth + Base.DecodeWidth + Base.RegIDWidth + (3 * Base.DataWidth)

  // EXRet and LSsrc
  val EX2LS_Width = Base.InstSize + 2 * Base.AddrWidth + Base.DecodeWidth + Base.RegIDWidth + (2 * Base.DataWidth)

  val LS2WB_Width = Base.InstSize + 2 * Base.AddrWidth + Base.DecodeWidth + Base.RegIDWidth + (2 * Base.DataWidth)
}

object CSR_LUT {

}