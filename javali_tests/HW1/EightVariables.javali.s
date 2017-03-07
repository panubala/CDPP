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
          movl -4(%ebp), %edi
          # Emitting 0
          movl $0, %esi
        movl %esi, -4(%ebp)
        # Emitting i1 = 1
          # Emitting i1
          movl -8(%ebp), %edi
          # Emitting 1
          movl $1, %esi
        movl %esi, -8(%ebp)
        # Emitting i2 = 2
          # Emitting i2
          movl -12(%ebp), %edi
          # Emitting 2
          movl $2, %esi
        movl %esi, -12(%ebp)
        # Emitting i3 = 3
          # Emitting i3
          movl -16(%ebp), %edi
          # Emitting 3
          movl $3, %esi
        movl %esi, -16(%ebp)
        # Emitting i4 = 4
          # Emitting i4
          movl -20(%ebp), %edi
          # Emitting 4
          movl $4, %esi
        movl %esi, -20(%ebp)
        # Emitting i5 = 5
          # Emitting i5
          movl -24(%ebp), %edi
          # Emitting 5
          movl $5, %esi
        movl %esi, -24(%ebp)
        # Emitting i6 = 6
          # Emitting i6
          movl -28(%ebp), %edi
          # Emitting 6
          movl $6, %esi
        movl %esi, -28(%ebp)
        # Emitting i7 = 7
          # Emitting i7
          movl -32(%ebp), %edi
          # Emitting 7
          movl $7, %esi
        movl %esi, -32(%ebp)
        # Emitting r1 = (i0 + (i1 + (i2 + (i3 + (i4 + (i5 + (i6 + i7)))))))
          # Emitting r1
          addl $-4, %esp
          # Emitting (i0 + (i1 + (i2 + (i3 + (i4 + (i5 + (i6 + i7)))))))
            # Emitting i0
            movl -4(%ebp), %esi
            # Emitting (i1 + (i2 + (i3 + (i4 + (i5 + (i6 + i7))))))
              # Emitting i1
              movl -8(%ebp), %edx
              # Emitting (i2 + (i3 + (i4 + (i5 + (i6 + i7)))))
                # Emitting i2
                movl -12(%ebp), %ecx
                # Emitting (i3 + (i4 + (i5 + (i6 + i7))))
                  # Emitting i3
                  movl -16(%ebp), %ebx
                  # Emitting (i4 + (i5 + (i6 + i7)))
                    # Emitting i4
                    movl -20(%ebp), %eax
                    # Emitting (i5 + (i6 + i7))
                      # Emitting i5
