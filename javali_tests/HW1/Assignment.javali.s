  # Emitting class Main {...}
    # Emitting void main(...) {...}
.LC0:
    .string "%d"
.LC1:
    .string "\n"
    .globl _main

_main:
    pushl %ebp
    movl %esp, %ebp
      # Emitting (...)
        # Emitting i0 = 0
          # Emitting i0
          addl $-4, %esp
          # Emitting 0
          movl $0, %edi
        movl %edi, -4(%ebp)
        # Emitting i1 = 1
          # Emitting i1
          addl $-4, %esp
          # Emitting 1
          movl $1, %edi
        movl %edi, -8(%ebp)
        # Emitting i2 = 2
          # Emitting i2
          addl $-4, %esp
          # Emitting 2
          movl $2, %edi
        movl %edi, -12(%ebp)
        # Emitting i3 = 3
          # Emitting i3
          addl $-4, %esp
          # Emitting 3
          movl $3, %edi
        movl %edi, -16(%ebp)
        # Emitting i4 = 4
          # Emitting i4
          addl $-4, %esp
          # Emitting 4
          movl $4, %edi
        movl %edi, -20(%ebp)
        # Emitting i5 = 5
          # Emitting i5
          addl $-4, %esp
          # Emitting 5
          movl $5, %edi
        movl %edi, -24(%ebp)
        # Emitting i6 = 6
          # Emitting i6
          addl $-4, %esp
          # Emitting 6
          movl $6, %edi
        movl %edi, -28(%ebp)
        # Emitting i7 = 7
          # Emitting i7
          addl $-4, %esp
          # Emitting 7
          movl $7, %edi
        movl %edi, -32(%ebp)
    movl $0, %eax
    leave
    ret
